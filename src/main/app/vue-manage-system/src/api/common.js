const setLocalStorage = function (key, value) {
    localStorage.setItem(key, JSON.stringify(value))
}

const getLocalStorage = function (key) {
    return JSON.parse(localStorage.getItem(key))
}

export default {
    setLocalStorage,
    getLocalStorage

}
