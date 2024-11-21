package kr.co.shortenurlservice.presentation;

import kr.co.shortenurlservice.domain.ShortenUrl;

public class ShortenUrlCreateResponseDto {
    private String shortenUrlKey;
    private String originalUrl;

    public ShortenUrlCreateResponseDto(ShortenUrl shortenUrl) {
        this.shortenUrlKey = shortenUrl.getOriginalUrl();
        this.originalUrl = shortenUrl.getShortenUrlKey();
    }

    public String getShortenUrl() {
        return shortenUrlKey;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
