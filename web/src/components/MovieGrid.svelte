<script>
  export let movies;
  import MovieCard from "./MovieCard.svelte";
</script>

<div class="MovieGrid">
  <div class="container">
    {#each movies as { title, rating, overview, poster_path, created_at, release_date }}
      <MovieCard
        {title}
        {rating}
        {overview}
        {poster_path}
        {created_at}
        {release_date}
      />
    {/each}
  </div>
</div>

<style>
  .MovieGrid {
    width: 100%;
    padding: 20px;
    box-sizing: border-box;
  }
  .container {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    width: 100%;
    gap: 10px;
  }
</style>
