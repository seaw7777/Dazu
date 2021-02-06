import { instance } from './index';
//마이페이지 유저 정보 가져오기
function MypageCustomerInfo(userid) {
  return instance.get(`member/selectMember/{id}?id=${userid}`);
}
// 마이페이지 고객님이 등록한 클래스 가져오기
function MypageCustomerClass(userid) {
  return instance.get(`member/selectMyclass/{id}?id=${userid}`);
}

export { MypageCustomerInfo, MypageCustomerClass };
