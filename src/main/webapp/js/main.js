// Live search for tables
document.addEventListener("DOMContentLoaded", function () {
    const searchBox = document.getElementById("searchBox");
    if (!searchBox) return;
    searchBox.addEventListener("keyup", function () {
        const query = this.value.toLowerCase();
        document.querySelectorAll("#studentTable tbody tr").forEach(row => {
            row.style.display = row.innerText.toLowerCase().includes(query) ? "" : "none";
        });
    });
});
