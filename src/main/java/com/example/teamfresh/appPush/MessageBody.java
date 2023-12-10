package com.example.teamfresh.appPush;

import com.example.teamfresh.model.Voc;
import lombok.Data;

@Data
public class MessageBody {
    private String title;
    private String body;


    public MessageBody(String title, String body) {
        this.title = title;
        this.body = body;
    }


    public static String bodyConstruct(Voc voc){
        return "안녕하세요." + voc.getDriver().getName() + "님, " +
                voc.getCustomer().getName() + "님으로 부터 VOC가 접수되었습니다. " +
                "VOC 내용: " + voc.getDescription() + "입니다." +
                "피해액 " + voc.getDamageAmount() + "원이 발생하였습니다. \n" +
                "이의 제기는 접수일 기준 3일 이내에 접수해주시기 바랍니다. \n" +
                "감사합니다.";
    }







}
