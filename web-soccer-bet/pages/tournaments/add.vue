<template>
  <div>
    
    <h1 class="mb-10 text-4xl font-extrabold leading-none tracking-tight text-gray-900 md:text-5xl lg:text-6xl dark:text-white">Form Tournament</h1>

    <form class="px-4 my-32 max-w-3xl mx-auto">
        <div>
            <label for="txt-image">
                URL Image
            </label>
            <input type="url" name="txt-image" id="txt-image"  placeholder="Enter URL Image"
                class="border border-gray-300  block py-2 px-4 w-full rounded focus:outline-none focus:border-teal-500"  >
        </div>

        <div>
            <label for="txt-name">
                Name
            </label>
            <input type="text" placeholder="Enter Name.." name="txt-name" id="txt-name"  
                class="border border-gray-300 block py-2 px-4 w-full rounded focus:outline-none focus:border-teal-500" />
        </div>

        <div>
            <label for="txt-description">Description</label>
            <textarea name="txt-description" id="txt-description" cols="30" rows="10" placeholder="Enter Description" 
                class="border border-gray-300 block py-2 px-4 w-full rounded focus:outline-none focus:border-teal-500" ></textarea>
        </div>

        <div>
            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-3" @click="addTournament">
                Save
            </button>
        </div>
    </form>

  </div>
</template>

<script setup>
import to from "await-to-js";
import axios from "axios";

definePageMeta({
  layout: "add-tournament",
});

const addTournament = async () =>{
    
    const url = "http://localhost:8095/api/tournaments/";
    const [err, response] = await to(axios.post(url));

    if (err) {
        console.log('Error cannot create new tournament');
        return;
    }

    if (response && response.status == 201) {
        console.log('Create with success...')
        return;
    }

    console.log('what happen...');

}


</script>

<style scoped></style>
