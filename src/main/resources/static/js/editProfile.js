function editField(field) {
    const value = prompt(`Enter new ${field}:`);
    if (value) {
        fetch(`/profile/update`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ [field]: value })
        })
            .then(response => {
                if (response.ok) {
                    alert(`${field} updated successfully!`);

                    document.getElementById(`${field}-field`).textContent = value;
                } else {
                    alert('Error updating profile!');
                }
            })
            .catch(error => {
                alert('Error updating profile!');
            });
    }
}