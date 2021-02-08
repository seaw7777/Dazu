import { instance } from './index';

function fetchNotices() {
  return instance.get('notice/list/');
}
function fetchNotice(noticecode) {
  return instance.get(`notice/detail/${noticecode}`);
}

export { fetchNotices, fetchNotice };
