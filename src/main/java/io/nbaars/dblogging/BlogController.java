package io.nbaars.dblogging;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@AllArgsConstructor
public class BlogController {

    public record BlogResponse(Long blogId, String author, Date publishDate) {
    }

    private BlogService blogService;

    @PostMapping
    public BlogResponse newBlog(@RequestBody BlogRequest blogRequest) {
        var newBlog = blogService.addBlog(blogRequest);
        return new BlogResponse(newBlog.getId(), newBlog.getAuthor(), newBlog.getPublishDate());
    }
}
