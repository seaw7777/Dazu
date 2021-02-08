import { instance } from './index';

// 로그아웃 API
function logoutUser(accessToken) {
  return instance.get(`logout/${accessToken}`);
}
// 고객님 추가 정보 보내기 API
function customerInfoAPI(customerInfo) {
  return instance.post('member/insertMember', customerInfo);
}
// 고객님 추가 정보 가져오기
function customerGetInfoAPI(id) {
  return instance.get(`member/selectMember/{id}?id=${id}`);
}
// 고객님의 7일이내 다가오는 클래스 정보
function customerUpcomingClass(id) {
  return instance.get(`member/selectCommingMyclass/{id}?id=${id}`);
}
// 사장님 추가 정보 보내기
function ownerInfoPost(ownerInfo) {
  return instance.post('member/insertMember', ownerInfo);
}
export {
  logoutUser,
  customerInfoAPI,
  customerGetInfoAPI,
  customerUpcomingClass,
  ownerInfoPost,
};
