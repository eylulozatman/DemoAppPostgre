document.addEventListener('DOMContentLoaded', function() {
    const studentForm = document.getElementById('studentForm');

    studentForm.addEventListener('submit', function(e) {
        e.preventDefault();

        const formData = new FormData(studentForm);
        const studentData = {};

        formData.forEach((value, key) => {
            studentData[key] = value;
        });

        // Convert studentData to JSON
        const jsonData = JSON.stringify(studentData);

        // Send a POST request to your endpoint
        fetch('/save-student', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: jsonData
        })
        .then(response => response.json())
        .then(data => {
            console.log('Student saved:', data);
            // You can redirect or display a success message here
        })
        .catch(error => {
            console.error('Error saving student:', error);
            // Handle errors here
        });
    });
});