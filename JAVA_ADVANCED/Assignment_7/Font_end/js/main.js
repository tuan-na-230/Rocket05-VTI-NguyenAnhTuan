window.onload = init;

async function init () {
    await model.callApi()
    view.showComponents('home')
}