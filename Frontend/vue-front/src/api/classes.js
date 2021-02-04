import { instance } from './index';
// 동별 클래스 목록 조회
function fetchClasses(dong) {
  return instance.get(`class/dong/${dong}`);
}
//특정 클래스 데이터 불러오기
function fetchClass(classCode) {
  return instance.get(`class/detail/${classCode}`);
}
// 가게 별 모든 클래스 정보 불러오기
function fetchStoreClass(storeCode) {
  return instance.get(`class/store/${storeCode}`);
}

export { fetchClasses, fetchClass, fetchStoreClass };
