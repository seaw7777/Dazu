import { instance } from './index';
// 동별 클래스 목록 조회
function fetchClasses(dong) {
  return instance.get(`class/dong/${dong}`);
}
//특정 클래스 데이터 불러오기
function fetchClass(classCode) {
  return instance.get(`class/detail/${classCode}`);
}
// 클래스별 리뷰 리스트 불러오기
function fetchClassReivew(classCode) {
  return instance.get(`class/review/${classCode}`);
}
// 클래스 리뷰 입력
function postReview(reviewData) {
  return instance.post('class/review/insert', reviewData);
}
// 가게 별 모든 클래스 정보 불러오기
function fetchStoreClass(storeCode) {
  return instance.get(`class/store/${storeCode}`);
}

export {
  fetchClasses,
  fetchClass,
  fetchStoreClass,
  fetchClassReivew,
  postReview,
};
//특정 클래스 공지사항 목록 조회
function fetchClassNotice(classCode) {
  return instance.get(`class/notice/${classCode}`);
}

export { fetchClasses, fetchClass, fetchClassNotice };
