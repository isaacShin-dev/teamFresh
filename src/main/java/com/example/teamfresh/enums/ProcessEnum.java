package com.example.teamfresh.enums;

public enum ProcessEnum {

    PROCESS_TYPE_0("REQ", "REQUEST"), // 고객사 최초 요청 시 가지는 상태
    PROCESS_TYPE_1("CON", "CONFIRM"), // 당사 담당자 확인 후 가지는 상태
    PROCESS_TYPE_2("PUS", "NOTIFIED"), // 확인 후 APP PUSH 알림 전송 후 가지는 상태
    PROCESS_TYPE_3("ACC", "ACCEPTED"), // 배송 기사가 잘못을 인정한 상태
    PROCESS_TYPE_4("REJ", "REJECTED"), // 배송 기사가 잘못을 부인한 상태
    PROCESS_TYPE_5("COM", "COMPLETED"); // 귀책 사유에 따른 배상이 모두 이루어진 상태

    private final String key;
    private final String value;

    ProcessEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        for (ProcessEnum processEnum : ProcessEnum.values()) {
            if (processEnum.key.equals(key)) {
                return processEnum.value;
            }
        }
        return null;
    }
}


