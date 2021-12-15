const base = "https://cinephilia-api.herokuapp.com";

const getAllMovies = async () => {
    const response = await fetch(base + "/movies", {
        method: "GET"
    })
    return response.json()
}

const getMovie = async (id) => {
    const response = await fetch(base + "/movies/" + id, {
        method: "GET"
    })
    return response.json()
}

const getMovieReviews = async (id) => {
    const response = await fetch(base + "/movies/" + id + "/reviews", {
        method: "GET"
    })
    return response.json()
}

export { getAllMovies, getMovie, getMovieReviews }
