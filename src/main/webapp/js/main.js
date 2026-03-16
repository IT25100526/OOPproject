// ── Driving School – main.js ──

// Live search filter for any table with id="studentTable"
document.addEventListener("DOMContentLoaded", function () {
    const searchBox = document.getElementById("searchBox");
    if (!searchBox) return;

    searchBox.addEventListener("keyup", function () {
        const query = this.value.toLowerCase();
        const rows  = document.querySelectorAll("#studentTable tbody tr");

        rows.forEach(function (row) {
            const text = row.innerText.toLowerCase();
            row.style.display = text.includes(query) ? "" : "none";
        });
    });
});
