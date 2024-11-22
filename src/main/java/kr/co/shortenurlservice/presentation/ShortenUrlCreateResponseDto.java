package kr.co.shortenurlservice.presentation;

import kr.co.shortenurlservice.domain.ShortenUrl;

public class ShortenUrlCreateResponseDto {
    private String shortenUrlKey;
    private String originalUrl;

    public ShortenUrlCreateResponseDto(ShortenUrl shortenUrl) {
        this.shortenUrlKey = shortenUrl.getShortenUrlKey();
        this.originalUrl = shortenUrl.getOriginalUrl();
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
