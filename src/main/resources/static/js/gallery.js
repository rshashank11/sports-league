let currentImageIndex = 0;
let currentGameImages = [];

function openModal(game) {
    const modal = document.getElementById("myModal");
    const imageGrid = document.getElementById("imageGrid");
    const modalTitle = document.getElementById("modalTitle");

    modalTitle.textContent = game.replace("-", " ").toUpperCase();
    imageGrid.innerHTML = "";

    currentGameImages = gamePhotos[game];
    currentGameImages.forEach(({ src, metadata }, index) => {
        const img = document.createElement("img");
        img.src = src;
        img.alt = metadata;
        img.onclick = () => enlargeImage(index);
        imageGrid.appendChild(img);
    });

    modal.style.display = "flex";
}

function closeModal() {
    document.getElementById("myModal").style.display = "none";
}

function enlargeImage(index) {
    currentImageIndex = index;
    const { src, metadata } = currentGameImages[index];

    const enlargedModal = document.getElementById("enlargedModal");
    const enlargedImage = document.getElementById("enlargedImage");
    const enlargedMetadata = document.getElementById("enlargedMetadata");

    enlargedImage.src = src;
    enlargedMetadata.textContent = metadata;
    enlargedModal.style.display = "flex";

    document.getElementById("prevButton").style.display = index === 0 ? "none" : "block";
    document.getElementById("nextButton").style.display = index === currentGameImages.length - 1 ? "none" : "block";
}

function navigateImage(direction) {
    const newIndex = currentImageIndex + direction;
    if (newIndex >= 0 && newIndex < currentGameImages.length) {
        enlargeImage(newIndex);
    }
}

function closeEnlargedModal() {
    document.getElementById("enlargedModal").style.display = "none";
}

window.onclick = function (event) {
    const modal = document.getElementById("myModal");
    const enlargedModal = document.getElementById("enlargedModal");

    if (event.target == modal) {
        closeModal();
    } else if (event.target == enlargedModal) {
        closeEnlargedModal();
    }
};

const gamePhotos = {
    dart: [
        { src: "/DART/Background.jpg", metadata: "Background of Dart Game" },
        { src: "/DART/dart.jpg", metadata: "Background of Dart Game" },
        { src: "/DART/demo.jpg", metadata: "Background of Dart Game" },
        { src: "/DART/pool.jpg", metadata: "Background of Dart Game" },
        { src: "/DART/Profile.jpg", metadata: "Background of Dart Game" },
        { src: "/DART/demo.jpg", metadata: "Background of Dart Game" },
        { src: "/DART/tabletennis.jpg", metadata: "Player showing dartboard" }
    ],
    "table-tennis": [
        { src: "/TT/sport.jpg", metadata: "Kids' Team" }
    ],
    pool: [
        { src: "/POOL/game.png", metadata: "World Cup details" }
    ]
};
