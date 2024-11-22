package kr.co.shortenurlservice.Application;

import kr.co.shortenurlservice.domain.NotFoundShortenUrlException;
import kr.co.shortenurlservice.domain.ShortenUrl;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleShortenUrlServiceTest {

    @Autowired
    private SimpleShortenUrlService simpleShortenUrlService;

    @Test
    @DisplayName("URL을 단축한 후 단축된 URl키로 조회하면 원래 URL이 조회되어야 한다.")
    void shortenUrlAddTest() {
        String expectedOriginalUrl = "https://www.hanbit.co.kr/";
        ShortenUrlCreateRequestDto shortenUrlCreateRequestDto = new ShortenUrlCreateRequestDto(expectedOriginalUrl);

        ShortenUrlCreateResponseDto shortenUrlCreateResponseDto =
                simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDto);
        String shortenUrlKey = shortenUrlCreateResponseDto.getShortenUrlKey();

        String originalUrl = simpleShortenUrlService.getOriginalUrlByShortenUrlKey(shortenUrlKey);

        assertTrue(originalUrl.equals(expectedOriginalUrl));

    }

     //존재하지 않는 단축 url을 조회하는 경우는 직접 해보기

    @Test
    @DisplayName("존재하지 않는 단축 url을 조회했을 경우 ")
    void notExistShortenUrlTest() {
        String originalUrl = "https://www.hanbit.co.kr/"; // 유알엘
        ShortenUrlCreateRequestDto shortenUrlCreateRequestDto = new ShortenUrlCreateRequestDto(originalUrl);
        ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDto); // 생성하고 저장까지 완료

        String unExistedShortenUrlKey = "https://djqtdma/";

        assertThrows(NotFoundShortenUrlException.class, () -> {simpleShortenUrlService.getOriginalUrlByShortenUrlKey(unExistedShortenUrlKey);});
    }

}

