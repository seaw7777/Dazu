import { instance } from './index';
// 가게 목록 조회
function fetchStore(dong) {
  return instance.get(`class/${dong}`);
}

export { fetchStore };
