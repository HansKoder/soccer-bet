<template>
  <div>

    <h1 class="mb-10 text-4xl font-extrabold leading-none tracking-tight text-gray-900 md:text-5xl lg:text-6xl dark:text-white">Tournaments</h1>

    <NuxtLink to="/tournaments/add" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        Add Tournament
    </NuxtLink>

    <div class="flex gaps-3 mt-10">
      <div class="max-w-sm rounded overflow-hidden shadow-lg" v-for="(item, index) in tournaments" :key="index">
        <img
          class="w-full"
          :src="item.image"
        />
        <div class="px-6 py-4">
          <div class="font-bold text-xl mb-2">
              <NuxtLink :to="`/tournaments/${item.id}`" > {{ item.name }} </NuxtLink>
          </div>
          <p class="text-gray-700 text-base">
            {{ item.description }}
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import to from "await-to-js";
import axios from "axios";

definePageMeta({
  layout: "tournaments",
});

const url = "http://localhost:8095/api/tournaments/";
const [err, response] = await to(axios.get(url));

const tournaments = err ? [] : response.data;

console.log("tournaments ", tournaments);
</script>

<style scoped></style>
