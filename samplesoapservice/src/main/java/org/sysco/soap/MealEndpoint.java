package org.sysco.soap;

import io.spring.guides.gs_producing_web_service.GetMealRequest;
import io.spring.guides.gs_producing_web_service.GetMealResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by chamarap on 3/27/17.
 */
@Endpoint
public class MealEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private MealRepository mealRepository;

    @Autowired
    public MealEndpoint(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMealRequest")
    @ResponsePayload
    public GetMealResponse getCountry(@RequestPayload GetMealRequest request) {
        GetMealResponse response = new GetMealResponse();
        response.setMeal(mealRepository.findMeal(request.getName()));

        return response;
    }
}