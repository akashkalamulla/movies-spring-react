package dev.farhan.movies.Service;

import dev.farhan.movies.Model.Movie;
import dev.farhan.movies.Model.Review;
import dev.farhan.movies.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody,String imdbId){
        Review review = reviewRepository.insert(new Review(imdbId));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}
