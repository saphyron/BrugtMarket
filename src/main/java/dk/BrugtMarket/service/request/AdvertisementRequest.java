package dk.BrugtMarket.service.request;

import dk.BrugtMarket.domain.Id;

public class AdvertisementRequest {
    private Id userId;
    private Id advertisementId;

    public AdvertisementRequest(Id userId, Id advertisementId) {
        this.userId = userId;
        this.advertisementId = advertisementId;
    }

    public Id getUserId() {
        return userId;
    }

    public Id getAdvertisementId() {
        return advertisementId;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userId=" + userId +
                ", advertisementId=" + advertisementId +
                '}';
    }
}
