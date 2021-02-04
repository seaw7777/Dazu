function saveAuthToCookie(value) {
  document.cookie = `til_auth=${value}`;
}

function saveUserToCookie(value) {
  document.cookie = `til_user=${value}`;
}

function saveImgToCookie(value) {
  document.cookie = `til_img=${value}`;
}

function saveCodeToCookie(value) {
  document.cookie = `til_code=${value}`;
}
function saveUserCodeToCookie(value) {
  document.cookie = `til_usercode=${value}`;
}
function getAuthFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)til_auth\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}

function getUserFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)til_user\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}
function getImgFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)til_img\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}
function getCodeFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)til_code\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}
function getUserCodeFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)til_usercode\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}

function deleteCookie(value) {
  document.cookie = `${value}=; expires=Thu, 01 Jan 1970 00:00:01 GMT;`;
}

export {
  saveAuthToCookie,
  saveUserToCookie,
  saveImgToCookie,
  saveCodeToCookie,
  saveUserCodeToCookie,
  getAuthFromCookie,
  getUserFromCookie,
  getImgFromCookie,
  getCodeFromCookie,
  getUserCodeFromCookie,
  deleteCookie,
};
