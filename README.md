# TeamFresh
### [POSTMAN 바로가기](https://www.postman.com/cloudy-satellite-470735/workspace/team-fresh/documentation/18550356-0fd91ced-e461-4203-89ca-565f77c268e3)

---
## API 목록

| 이름 | 비고 | 요청 uri |
| --- | --- | --- |
| 고객사 | 고객사 정보를 등록하고 관리합니다. | `/api/v1/customer/` |
| 운송사 | 운송사 정보를 등록하고 관리합니다. | `/api/v1/deliveryComp/` |
| 기사 | 운송사에 소속된 기사 정보를 등록하고 관리합니다. | `/api/v1/driver/` |
| VOC | 고객사에서 발행하는 클레임을 등록하고 관리하며, 배상 기능을 수행합니다. | `/api/v1/voc/` |


### 고객사 API
| 요청명 | Http Method | 요청 주소 | 비고 |
| --- | --- | --- | --- |
| 신규 고객사 생성 | POST | `api/v1/customer/` |  |
| 고객사 단일 조회 | GET | `/api/v1/customer/{id}/` |  |
| 고객사 리스트 조회 | GET | `/api/v1/customer/?{active=Boolean}` | 1\. 해당 고객사에서 발행한 VOC 리스트를 함께 JSON 에 담아 반환합니다.  <br>  <br>2\. 쿼리 파라미터 **`active`** 에 값을 담아 활성 상태에 대한  <br>간단한 필터링도 가능합니다. |
| 고객사 삭제  <br>(활성 상태 변경) | PATCH | /api/v1/customer/{id}/ | 현재 활성 상태를 변경합니다. |
| 고객사 정보 업데이트  <br>(담당자 정보 수정) | PUT | /api/v1/customer/{id}/ | 계약 상태(**`true`**) 상태인 고객사만 정보를 변경할 수 있습니다. |

- 기본적인 CRUD 기반이지만, `DELETE` 요청이 존재하지 않습니다. 고객 관리 정책에 따라 다르겠지만, 계약 만료 시 고객 테이블과 VOC 관련 데이터베이스에서 즉각 삭제하기 보다 추후 발생할 수 있는 문제에 대비하기 위해 고객사 활성화(`Boolean`) 를 통한 계약 상태를 업데이트 하기 위해 정보를 `PATCH` 하는 방향으로 설계하였습니다.
    - 추후, 계약 상태와 계약 내용을 가지는 테이블을 별도 생성 후, 정책 번호 ex) `uuid`를 활용, 계약 내용에 따라 고객사를 분리하여 관리하는 확장도 가능할 것이라 생각합니다.
 
### 기사 API
| 요청명 | HTTP Method | 요청 주소 | 비고 |
|:------:|:-----------:|:---------:|:----:|
| 신규 기사 생성 | `POST` | `/api/v1/driver/{운송사_id}` |  |

### VOC API
| 요청명 | HTTP Method | 요청 주소 | 비고 |
|:------:|:-----------:|:---------:|:----:|
| 신규 VOC 생성 | `POST` | `/api/v1/voc/?customerId={id}&driverId={id}` | `customerId`: 고객사 id, `driverId`: 배송기사 id |
| VOC 전체 조회 | `GET` | `/api/v1/voc/?processKey={process_type_enum}` | VOC 진행 단계 상태에 따른 필터링 (`PROCESS_TYPE_n`) |
| VOC 귀책 사유 등록 및 APP PUSH | `PATCH` | `/api/v1/voc/{vocId}/?faultCode=1` | 귀책 사유에 따른 패널티, 또는 배상 등록 후 VOC 진행 단계를 변경하고, APP PUSH 를 보냅니다. |
| APP PUSH 기사 응답 | `PATCH` | `/api/v1/voc/{vocId}/{penaltyId}/?isAccepted=true` | `isAccepted`: 귀책을 인정 여부 |

