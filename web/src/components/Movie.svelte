<script>
    import { onMount } from "svelte";
    import MovieCard from "./MovieCard.svelte";
    import { getMovieReviews } from "../api/cinephilia";
    export let movie;
    let reviews;

    async function populateReviews() {
        console.log(movie.id);
        reviews = await getMovieReviews(movie.id);
        console.log(typeof reviews);
    }

    onMount(populateReviews);
</script>

<MovieCard
    title={movie.title}
    rating={movie.rating}
    overview={movie.overview}
    poster_path={movie.poster_path}
    created_at={movie.created_at}
    release_date={movie.release_date}
    id={movie.id}
/>

{#if reviews}
    <ul>
        {#each reviews as review}
            <li>
                {review.author.username}: {review.content}
            </li>
        {/each}
    </ul>
{/if}

<style>
</style>
