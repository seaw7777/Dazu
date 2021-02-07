import { instance } from './index';

function fetchNotices() {
  return instance.get('notice/list/');
}

export { fetchNotices };
