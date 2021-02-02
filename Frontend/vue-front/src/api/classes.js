import { instance } from './index';
// 클래스 목록 조회
function fetchClass(dong) {
  return instance.get(`class/dong/${dong}`);
}

export { fetchClass };
