package io.nbaars.dblogging;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@AllArgsConstructor
public class BlogService {

    private BlogRepository blogRepository;

    public Blog addBlog(BlogRequest newBlog) {
        var contents = new String(Base64.getDecoder().decode(newBlog.contents()), StandardCharsets.UTF_8);
        var blog = new Blog(newBlog.author(), newBlog.title(), contents);
        return blogRepository.save(blog);
    }
}
