<!-- TEMPORAL -->
<script>
  export let poster_path;
  export let title;
  export let overview;
  export let rating;

  import Stars from "./Stars/Stars.svelte";
</script>

<div class=" container content is-medium">
  <img src={poster_path} alt={title} />
  <div class="Content">
    <div class="title">
      <h4>{title}</h4>
    </div>
    <div class="shortDescription">
      <h5>
        {overview}
      </h5>
    </div>

    <Stars {rating} />
  </div>
</div>

<style>
  .container {
    position: relative;
    display: inline-block;
    text-align: center;
  }

  img {
    width: 65%;
    height: auto;
    object-fit: cover;
  }

  .Content {
    position: absolute;
    top: 80%;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  h4,
  h5 {
    margin: 0;
    padding: 5px 0;
    color: rgb(250, 250, 248);
    text-shadow: 2px 2px rgb(0, 0, 0);
  }

  .title {
    margin-bottom: 0.5rem;
  }
</style>
