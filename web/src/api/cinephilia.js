const base = "https://cinephilia-api.herokuapp.com";

const getAllMovies = async () => {
    const response = await fetch(base + "/movies", {
        method: "GET"
    })
    return response.json()
}

export { getAllMovies }
