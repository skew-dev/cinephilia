<script>
  export let title;
  export let id;
  //posiblemente se podria cambiar por una descripcion larga
  export let overview;
  export let poster_path;
  export let created_at;
  export let release_date
  let date = new Date(created_at);
</script>

<div class="card">
  <div class="card-content">
    <div class="columns is-vcentered">
      <div class="columns is-vcentered">
        <div class="column">
          <a href="movie/{id}" class="button"> Reviews </a>
        </div>
        <div class="column">
          <button class="button"> Rate </button>
        </div>
      </div>
    </div>
  </div>
  <div class="card-image">
    <figure class="image is-5by3">
      <img src={poster_path} alt={title} />
    </figure>
  </div>
  <div class="card-content">
    <div class="media">
      <div class="media-content">
        <p class="title is-4">{title}</p>
        <p class="subtitle is-6">{release_date}</p>
      </div>
    </div>

    <div class="content">
      {overview}
      <br />
      <time class="subtitle is-6" datetime="2016-1-1"
        >{date.toLocaleDateString("en-US")}</time
      >
    </div>
  </div>
</div>

<style>
</style>
