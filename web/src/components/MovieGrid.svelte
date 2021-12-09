<script>
  export let movieList;
  import MovieCard from "./MovieCard.svelte";
</script>

<div class="MovieGrid">
  <div class="container">
    {#each movieList as { title, rating, shortDescription }}
      <MovieCard {title} {rating} {shortDescription} />
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
