import { instance } from './index';
//마이페이지 유저 정보 가져오기
function MypageCustomerInfo(usercode) {
  return instance.get(`member/selectMember/{id}?id=${usercode}`);
}
// 마이페이지 고객님이 등록한 클래스 가져오기
function MypageCustomerClass(usercode) {
  return instance.get(`member/selectMyclass/{id}?id=${usercode}`);
}
// 마이페이지 고객님의 7일 남은 클래스 가져오기
function MypageCustomerComingClass(usercode) {
  return instance.get(`member/selectCommingMyclass/{id}?id=${usercode}`);
}
function MypageCustomerEditAddress(addressinfo) {
  return instance.put('member/updateMember', addressinfo);
}
// 마이페이지에 사장님 가게 정보를가지고 온다.
function MypageOwnerInfo(usercode) {
  return instance.get(`store/detail/${usercode}`);
}
export {
  MypageCustomerInfo,
  MypageCustomerClass,
  MypageCustomerComingClass,
  MypageCustomerEditAddress,
  MypageOwnerInfo,
};
