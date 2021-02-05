import { instance } from './index';
//마이페이지 유저 정보 가져오기
function MypageCustomerInfo(id) {
  return instance.get(`member/selectMember/{id}?id=${id}`);
}

export { MypageCustomerInfo };
