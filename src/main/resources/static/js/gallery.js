async function fetchGalleryData() {
    try {
        const response = await fetch('/gallery/data'); // Fetch JSON data from the backend
        if (!response.ok) {
            throw new Error(`Failed to fetch gallery data: ${response.statusText}`);
        }

        const games = await response.json(); // Parse the JSON response

        const galleryContainer = document.querySelector('.gallery');
        galleryContainer.innerHTML = ""; // Clear existing gallery content

        games.forEach(game => {
            const gameDiv = document.createElement('div');
            gameDiv.classList.add('gallery-item');

            gameDiv.onclick = () => openModal(game.slug); // Pass the game slug

            const img = document.createElement('img');
            // img.src = game.photos?.length > 0 ? `/images/${game.photos[0].src}` : '/images/default.jpg'; // Construct image URL without extra slug
            img.src = game.photos?.length > 0 ? `${game.photos[0].src}` : '/images/default.jpg'; // Construct image URL without extra slug
            img.alt = game.name;

            const nameDiv = document.createElement('div');
            nameDiv.classList.add('game-name');
            nameDiv.textContent = game.name;

            gameDiv.appendChild(img);
            gameDiv.appendChild(nameDiv);
            galleryContainer.appendChild(gameDiv);
        });
    } catch (error) {
        console.error("Error loading gallery data:", error);
    }
}

async function openModal(gameSlug) {
    try {
        const response = await fetch(`/gallery/data`); // Fetch all games' data for the modal
        if (!response.ok) {
            throw new Error(`Failed to fetch game data: ${response.statusText}`);
        }

        const games = await response.json();
        const game = games.find(g => g.slug === gameSlug); // Find the specific game by slug

        const modal = document.getElementById("myModal");
        const imageGrid = document.getElementById("imageGrid");
        const modalTitle = document.getElementById("modalTitle");

        modalTitle.textContent = game.name;
        imageGrid.innerHTML = ""; // Clear the image grid

        if (game.photos && game.photos.length > 0) {
            game.photos.forEach((photo, index) => {
                const img = document.createElement("img");
                // img.src = `/images/${photo.src}`; // Use the correct image URL
                img.src = `${photo.src}`; // Use the correct image URL
                img.alt = photo.metadata || `Photo ${index + 1}`;
                img.onclick = () => enlargeImage(game.photos, index); // Pass the array and index for enlarging
                imageGrid.appendChild(img);
            });
        } else {
            const message = document.createElement("div");
            message.textContent = "No photos available.";
            imageGrid.appendChild(message);
        }

        modal.style.display = "flex"; // Show the modal
    } catch (error) {
        console.error("Error opening modal:", error);
    }
}

function enlargeImage(photos, index) {
    const enlargedModal = document.getElementById("enlargedModal");
    const enlargedImage = document.getElementById("enlargedImage");
    const enlargedMetadata = document.getElementById("enlargedMetadata");

    // enlargedImage.src = `/images/${photos[index].src}`;
    enlargedImage.src = `${photos[index].src}`;
    enlargedMetadata.textContent = photos[index].metadata || "";

    enlargedModal.style.display = "flex"; // Show the enlarged modal
    enlargedModal.dataset.currentIndex = index;
    enlargedModal.dataset.photos = JSON.stringify(photos); // Store photos data for navigation
}

function navigateImage(offset) {
    const enlargedModal = document.getElementById("enlargedModal");
    const currentIndex = parseInt(enlargedModal.dataset.currentIndex, 10);
    const photos = JSON.parse(enlargedModal.dataset.photos);

    const newIndex = (currentIndex + offset + photos.length) % photos.length;
    enlargeImage(photos, newIndex);
}

function closeModal() {
    const modal = document.getElementById("myModal");
    modal.style.display = "none"; // Close the modal
}

function closeEnlargedModal() {
    const enlargedModal = document.getElementById("enlargedModal");
    enlargedModal.style.display = "none"; // Close the enlarged modal
}

// Initial call to load gallery data
fetchGalleryData();
