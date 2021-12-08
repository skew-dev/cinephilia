<!-- TEMPORAL -->
<script>
  export let title;
  export let shortDescription;
  export let rating;
</script>

<div class=" container content is-large">
  <div class="block">
    {title}
  </div>
  <div class="block">
    {shortDescription}
  </div>
  <div class="block">{rating}</div>
</div>

<style>
  .container {
    text-align: center;

  }
</style>
