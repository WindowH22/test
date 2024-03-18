package com.kiki.cgvmecro.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class crawler {

    @Scheduled(cron = "* * * * * *") // 매 1초마다 실행
    public void noticeCrawler() throws Exception {
        // 자동업데이트
         WebDriverManager.chromedriver().setup();
        // 수동 업데이트
        // https://storage.googleapis.com/chrome-for-testing-public/122.0.6261.57/mac-x64/chromedriver-mac-x64.zip
//        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-popup-blocking");   // 팝업 안띄움
//        options.addArguments("headless");   // 브라우저 안띄움
        options.addArguments("--disable-gpu");  // gpu 비활성화
//        options.addArguments("--blink-settings=imagesEnabled=false");   // 이미지 다운 안받음
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);



        driver.get("http://www.cgv.co.kr/ticket/");
        String value = "UserName=8ef054212d674eb6&Email=b13dc4a09c8832e623162ce5d3bbb6aecdb20ea972d54ebe&Seq=d3036b99d587d7bedac630c05b600877&Ssn=007f5cf958f1682b38e6942901a1ac5f&UserGrade=265398f2a4d9ba81&UserPoint=3bd4992a431e6ca9&MemberCd=18118d33552da821af0755030f2407d3&GenreCode=3bd4992a431e6ca9&Phone=&Mobile=6162591c707b676aef009408ad2cce97&IsAdult=Y&IsVip=N&IsCjEnter=N&IsCJVip=N&IsCgvEmployee=N&IsCjEmployee=N&Age=7429425cf6a393b5&WatchingMovie=&BirthYear=bf61ca07f60fa245&EncUserId=b13dc4a09c8832e6713791fff126b119&BirthDate=19970413&Status=10&FavoriteTheaters=0128,0304,&FavoriteTheaterNames=201e7a0143affe4180afd2e594283db37359c754604d873cb46603ef59e4d207&IsSupporters=&IPIN_YN=N&Ipin_realssn_YN=Y&CjmsPoint=&Agr_Typ_Yn=10:Y:20150728:223739,20:Y:20150728:223739&UserName_RIA=VEDFWR%2fp6qhMqaTxjeMevA%3d%3d&Email_RIA=LjqxZflrmIlF%2bL5aBmpMRhuehmbNnednEjx%2fSQEp43E%3d&Ssn_RIA=bIKpsUPYYhn8RQ6IQ%2fqdkQ%3d%3d&Phone_RIA=&Mobile_RIA=Flsyb23cdfHnJwA%2bL%2bZHVw%3d%3d&IsCardYN=N&IsPartners=N&IsCgvVip=N&UserGradeTypes=N&Code_RIA=P9gGbgibnUUy5Lch7jj6DQ%3d%3d&Ipin_CI=ZzSJtaCh7JtxYtzQcuGY%2b8A3TxAl%2fsa%2bIk6C42wq5jwOnkeFTqPehfa0V%2f%2bpO2W63A1Z5pruN3pbRARG2Z5zdn1qbsBHJEd0ksKX6fQEHRl2ix7t3Xzx20otWF5myjWU&LCT_BIRTHDATE=bIKpsUPYYhn8RQ6IQ%2fqdkQ%3d%3d&SEX=75b42389b31a2e2a&IsMiso=N&IsRiaSupporters=N&IsFreePassCard=N&IsBeforeVip=N&IsClubX=N&IsGetVipCoupon=0&PayMethod=&UserName_HRIA=Flk9974XgMHUManU0D9A1g%3d%3d&EMail_HRIA=Y98sJThBQ2F0cm%2bKaI52UWrGEY4FcdmSxifjL7Flu94%3d&PHONE_HRIA=nG6tVgEQPGU2GvOIdnwTjg%3d%3d&MOBILE_HRIA=97dhnse0Laz8YM3OFxpmfw%3d%3d&IPIN_CI_HRIA=DvORFDrywtuIYWfjn9KQrzaamVUCoNOckWr8m4CFu17SCOUxZRUD3CGGIDv9Sy40NVo1tJ4K%2b5472dyRScDoW9QGBsIq852Q96CqcqKVBoTekJlUfh4lk473naC06hBk&PAYMETHOD_HRIA=nG6tVgEQPGU2GvOIdnwTjg%3d%3d&Lct_BirthDate_HRIA=JMjNJKn6Rh1T02k9yxVpNg%3d%3d&FavoriteTheaters_HRIA=7XBifko7Q6PMBbqDfI0wHw%3d%3d&IsAduit_HRIA=3y%2bGIXzg3xKpOjlKjH8%2bFg%3d%3d&IsCgvEmployee_HRIA=ECFppiyFz%2fnvSGsg7VwPQw%3d%3d&isCJEnter_HRIA=ECFppiyFz%2fnvSGsg7VwPQw%3d%3d&isCgvVip_HRIA=ECFppiyFz%2fnvSGsg7VwPQw%3d%3d&Ipin_realssn_YN_HRIA=3y%2bGIXzg3xKpOjlKjH8%2bFg%3d%3d&Code_HRIA=JLplbXV5WAo%2b0C4Bo6z5%2bA%3d%3d&UserId_HRIA=%2bSK8ktmMm%2bJVT1Ct9rlO%2fA%3d%3d&IS_CJ_EMPLOYEE_HRIA=ECFppiyFz%2fnvSGsg7VwPQw%3d%3d&IS_SOLDIER_YN_HRIA=ECFppiyFz%2fnvSGsg7VwPQw%3d%3d&LoginExpireTime=d31a7bf0f29391b145f9f847243444efdfb8d2e5a227902ee7c34e2c843d99b9&UserID_RE=%2bSK8ktmMm%2bJVT1Ct9rlO%2fA%3d%3d&CODE_RE=JLplbXV5WAo%2b0C4Bo6z5%2bA%3d%3d&Exsiting_Id_RE=nG6tVgEQPGU2GvOIdnwTjg%3d%3d";
        Cookie loginCookie = new Cookie("cgv.cookie", value, ".cgv.co.kr","/", null );
        driver.manage().addCookie(loginCookie);
        driver.get("http://www.cgv.co.kr/ticket/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofMillis(10000));

        // 해당 XPath를 사용하여 요소 찾기 (기다리며 찾기)


        driver.switchTo().frame("ticket_iframe");


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"movie_list\"]/ul/li[1]/a"))).click();
        // imax
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sbmt_imax\"]/a"))).click();
        //지역 선택
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"theater_area_list\"]/ul/li[2]/a"))).click();
        // 용아맥
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"theater_area_list\"]/ul/li[2]/div/ul/li[@theater_cd='0013']/a"))).click();

        // 해당 ul 요소 내에서 date 속성이 20240324인 li 요소 찾기
        while(true){

            try {
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//li[@date='20240324']"))).click();
                int count = 0;
                // todo: 0324 가 언제뜰지 계속 봀수 있는 함수를 만들어야함
                // alert가 뜰 때까지 대기
                webDriverWait.until(ExpectedConditions.alertIsPresent());

                Alert alert = driver.switchTo().alert();

                // alert 창 닫기 (확인 버튼 클릭)
                alert.dismiss();
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"theater_area_list\"]/ul/li[2]/div/ul/li[@theater_cd='0013']/a"))).click();
                count ++;
                if( count % 100 == 0){
                    log.info(count+"번 째 시도중");
                }

            } catch (NoAlertPresentException e) {
                // alert가 없는 경우에는 아무 작업도 하지 않고 다음 동작을 이어감

                log.info("경고문이 뜨지 않았습니다.");
                break;
            } catch (TimeoutException e){
                log.info("시간이 지나도 경고문이 뜨지 않았습니다.");
                break;
            } catch (ElementClickInterceptedException e){
                log.info("안잡혀요 ㅠㅠㅠ");
            }
        }


        // 아이맥스 두번째 시간 클릭
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ticket\"]/div[2]/div[1]/div[4]/div[2]/div[3]/div[1]/div[1]/ul/li[2]/a"))).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tnb_step_btn_right\"]"))).click();
        // 해당 XPath를 사용하여 요소 찾기
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[3]/a"))).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nop_group_adult\"]/ul/li[3]/a"))).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"seats_list\"]/div[1]/div[8]/div[3]/div/div[6]/a"))).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // JavaScript를 사용하여 seat 클래스 제거
        String script = "var elements = document.querySelectorAll('div.seat.reserved');" +
                "elements.forEach(function(element) {" +
                "   element.classList.remove('reserved');" +
                "});";
        js.executeScript(script);

        findSeat(webDriverWait,driver);

        // 결제 페이지
        log.info("결제 페이지 진입");
        try{
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText(); // alert 창의 메시지 가져오기

            // alert 창 닫기 (확인 버튼 클릭)
            alert.accept();
        }
        catch (NoAlertPresentException e) {
            // alert가 없는 경우에는 아무 작업도 하지 않고 다음 동작을 이어감
            log.info(e.getMessage());

        } catch (TimeoutException e){
            log.info(e.getMessage());
        }

        WebElement selectElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_type\"]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_type\"]/option[13]"))).click();

        Select select = new Select(selectElement);
        select.selectByVisibleText("카카오뱅크카드");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_no1\"]"))).sendKeys("5365");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_no2\"]"))).sendKeys("1042");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_no3\"]"))).sendKeys("9307");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_no4\"]"))).sendKeys("4389");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_month\"]"))).sendKeys("09");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_year\"]"))).sendKeys("28");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_pw\"]"))).sendKeys("");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lp_card_ssn\"]"))).sendKeys("970413");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tnb_step_btn_right\"]"))).click();

        // 동의
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"agreementAll\"]"))).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"resvConfirm\"]"))).click();


        // 최종 결제 승인
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[3]/a[1]"))).click();

        log.info("결제 완료 ");

//         WebDriver 종료
//        driver.quit();

    }


    public void findSeat(WebDriverWait webDriverWait, WebDriver driver){

        List<String> seatXpath = new ArrayList<>();
//*[@id="seats_list"]/div[1]/div[8]/div[3]/div/div[7]/a//*[@id="seats_list"]/div[1]/div[8]/div[3]/div/div[7]/a
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[12]/div[4]/div/div[7]/a"); // L열 22,23
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[11]/div[4]/div[2]/div[3]/a"); // K열 22,23
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[10]/div[4]/div/div[7]/a"); // J열 22,23
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[9]/div[4]/div/div[7]/a"); // I열 22,23
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[8]/div[3]/div/div[7]/a"); // H열 22, 23
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[7]/div[3]/div/div[7]/a"); // G열 22,    23
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[13]/div[4]/div/div[7]/a"); // M열 22, 23


        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[12]/div[4]/div/div[9]/a"); // L열 24,25
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[11]/div[4]/div[2]/div[5]/a"); // K열 24,25
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[10]/div[4]/div/div[9]/a"); // J열 24,25
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[9]/div[4]/div/div[9]/a"); // I열 24,25


        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[8]/div[3]/div/div[9]/a"); // H열 24,25
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[7]/div[3]/div/div[9]/a"); // G열 24,25
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[13]/div[4]/div/div[9]/a"); // M열 24,25

        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[12]/div[4]/div/div[5]/a"); // L열 20,21
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[11]/div[4]/div[2]/div[1]/a"); // K열 20,21
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[10]/div[4]/div/div[5]/a"); // J열 20,21
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[9]/div[4]/div/div[5]/a"); // I열 20,21

        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[8]/div[3]/div/div[5]/a"); // H열 20, 21

        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[7]/div[3]/div/div[5]/a"); // G열 20, 21
        seatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[13]/div[4]/div/div[5]/a"); // M열 20, 21
        List<String> unSeatXpath = new ArrayList<>();

        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[12]/div[4]/div[2]/div[1]/a"); // L열 선택해제할때
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[11]/div[4]/div[3]/div[1]/a"); //  K열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[10]/div[4]/div[2]/div[1]/a"); // J열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[9]/div[4]/div[2]/div[1]/a"); // I열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[8]/div[3]/div[2]/div[1]/a"); // H열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[7]/div[3]/div[2]/div[1]/a"); // G열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[13]/div[4]/div[2]/div[1]/a"); // M열 선택해제

        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[12]/div[4]/div[2]/div[1]/a"); // L열 선택해제할때
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[11]/div[4]/div[3]/div[1]/a"); //  K열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[10]/div[4]/div[2]/div[1]/a"); // J열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[9]/div[4]/div[2]/div[1]/a"); // I열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[8]/div[3]/div[2]/div[1]/a"); // H열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[7]/div[3]/div[2]/div[1]/a"); // G열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[13]/div[4]/div[2]/div[1]/a"); // M열 선택해제

        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[12]/div[4]/div[2]/div[1]/a"); // L열 선택해제할때
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[11]/div[4]/div[2]/div[1]/a"); //  K열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[10]/div[4]/div[2]/div[1]/a"); // J열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[9]/div[4]/div[2]/div[1]/a"); // I열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[8]/div[3]/div[2]/div[1]/a"); // H열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[7]/div[3]/div[2]/div[1]/a"); // G열 선택해제
        unSeatXpath.add("//*[@id=\"seats_list\"]/div[1]/div[13]/div[4]/div[2]/div[1]/a"); // M열 선택해제



        for (int i = 0; i < seatXpath.size(); i++) {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(seatXpath.get(i)))).click();

            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tnb_step_btn_right\"]"))).click();

            try {
                // alert가 뜰 때까지 대기
                webDriverWait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                String alertMessage = alert.getText(); // alert 창의 메시지 가져오기
                log.info("Alert message: " + alertMessage);

                // alert 창 닫기 (확인 버튼 클릭)
                alert.accept();

                // 다시 눌러서 선택해제
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(unSeatXpath.get(i)))).click();
            } catch (NoAlertPresentException e) {
                // alert가 없는 경우에는 아무 작업도 하지 않고 다음 동작을 이어감
                log.info(e.getMessage());
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tnb_step_btn_right\"]"))).click();
                break;
            }catch (TimeoutException e){
//                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tnb_step_btn_right\"]"))).click();
                log.info(e.getMessage());


                // 만약 선택된 후라면? -> 다시 눌러서 선택해제;
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(unSeatXpath.get(i)))).click();
            }
        }
    }



    public static void main(String[] args) throws Exception {
        crawler ls = new crawler();
        ls.noticeCrawler();
    }
}
