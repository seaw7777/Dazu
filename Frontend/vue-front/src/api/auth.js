import { instance } from './index';

// 로그아웃 API
function logoutUser(accessToken) {
  return instance.get(`logout/${accessToken}`);
}
// 고객님 추가 정보 API
function customerInfoAPI(customerInfo) {
  return instance.post('member/insertMember', customerInfo);
}
export { logoutUser, customerInfoAPI };
