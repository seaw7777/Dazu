import { instance } from './index';
// 동별 클래스 목록 조회
function fetchClasses(dong) {
  return instance.get(`class/dong/${dong}`);
}
//특정 클래스 데이터 불러오기
function fetchClass(classCode) {
  return instance.get(`class/detail/${classCode}`);
}
//특정 클래스 공지사항 목록 조회
function fetchClassNotice(classCode) {
  return instance.get(`class/notice/${classCode}`);
}

export { fetchClasses, fetchClass, fetchClassNotice };
