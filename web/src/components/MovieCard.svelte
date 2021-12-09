<script>
  export let title;
  export let rating;
  //posiblemente se podria cambiar por una descripcion larga
  export let shortDescription;
</script>

<div class="MovieCard">
  <div class="container">
    <div class="header">
      <div class="header-title">{title}</div>
      <div class="rating">{rating}</div>
      <button on:click>Rate</button>
    </div>
    <div class="content">
      <div class="movie-image">
        <!-- aqui va a ir una imagen de la pelicula, pero temporalmente es solo texto -->
        Imagen de la pelicula
      </div>
      <div class="title">
    {title}
      </div>
      <div class="description">
        <!-- posiblemente se puede cambiar por una descripcion larga -->
        {shortDescription}
      </div>
    </div>
  </div>
</div>

<style>
  .container {
    background-color: chartreuse;
    border-radius: 3px;
    border: solid 2px transparent;
    overflow: hidden;
    height: 400px;
  }

  .MovieCard .container .header {
    padding: 0.5rem;
  }

  .header {
    display: flex;
    justify-content: space-between;
  }

  .movie-image {
    background-color: antiquewhite;
    width: 100%;
    margin-left: auto;
    margin-right: auto;
    height: 8rem;
  }

  .container .content .title {
    padding: 1rem;
    text-align: left;
  }
</style>
