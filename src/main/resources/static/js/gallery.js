async function fetchGalleryData() {
    const response = await fetch('/gallery');
    const games = await response.json();

    const galleryContainer = document.querySelector('.gallery');
    galleryContainer.innerHTML = "";

    games.forEach(game => {
        const gameDiv = document.createElement('div');
        gameDiv.classList.add('gallery-item');
        gameDiv.onclick = () => openModal(game.slug);

        const img = document.createElement('img');
        img.src = game.photos?.length > 0 ? game.photos[0].src : '/default.jpg'; // Default image if no photos
        img.alt = game.name;

        const nameDiv = document.createElement('div');
        nameDiv.classList.add('game-name');
        nameDiv.textContent = game.name;

        gameDiv.appendChild(img);
        gameDiv.appendChild(nameDiv);
        galleryContainer.appendChild(gameDiv);
    });
}

async function openModal(gameSlug) {
    const response = await fetch(`/api/gallery/${gameSlug}`);
    const game = await response.json();

    const modal = document.getElementById("myModal");
    const imageGrid = document.getElementById("imageGrid");
    const modalTitle = document.getElementById("modalTitle");

    modalTitle.textContent = game.name;
    imageGrid.innerHTML = "";

    if (game.photos && game.photos.length > 0) {
        game.photos.forEach((photo, index) => {
            const img = document.createElement("img");
            img.src = photo.src;
            img.alt = photo.metadata || `Photo ${index + 1}`;
            img.onclick = () => enlargeImage(index);
            imageGrid.appendChild(img);
        });
    } else {
        const message = document.createElement("div");
        message.textContent = "No photos available.";
        imageGrid.appendChild(message);
    }

    modal.style.display = "flex";
}

fetchGalleryData();


