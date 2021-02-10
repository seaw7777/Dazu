import { instance } from './index';
// 행정동의 모든 가게 정보를 가져온다.
function fetchStore(dong) {
  return instance.get(`store/list/${dong}`);
}
// 가게별 등록된 모든 클래스 정보를 가지고 온다.
function fetchStoreClassInfo(storecode) {
  return instance.get(`class/store/${storecode}`);
}
export { fetchStore, fetchStoreClassInfo };
