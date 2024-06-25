$(document).ready(function() {
    ajaxGetSports();
});

function ajaxGetSports() {     
    let checkboxContainer = $('#checkbox-container');
    const itemsPerPage = 5; // Number of checkboxes per page
    let currentPage = 1; // Current page number

    if (!checkboxContainer.length) {
        console.error('Checkbox container element not found');
        return;
    }

    checkboxContainer.empty();
    
    const url = '/getsports';
    
    $.getJSON(url, function(data) {
        if (!data || data.length === 0) {
            console.warn('No data received or data is empty');
            return;
        }

        let allItems = []; // Array to store all checkbox items

        $.each(data, function(key, entry) {
            let checkbox = $('<input />', { type: 'checkbox', name: 'selectedSports', id: 'sports_' + key, value: entry.sportsName });
            let label = $("<label/>", { 'for': 'sports_' + key, text: entry.sportsName });
            
            // Wrap checkbox and label in a div for easier manipulation
            let checkboxWrapper = $('<div class="checkbox-item"></div>');
            checkboxWrapper.append(checkbox).append(label);
            allItems.push(checkboxWrapper); // Add to all items array
        });

        // Function to display checkboxes for a specific page
        function displayCheckboxes(page) {
            checkboxContainer.empty();
            let startIndex = (page - 1) * itemsPerPage;
            let endIndex = startIndex + itemsPerPage;
            for (let i = startIndex; i < endIndex && i < allItems.length; i++) {
                checkboxContainer.append(allItems[i]);
            }
        }

        // Show initial page of checkboxes
        displayCheckboxes(currentPage);

        // Function to update pagination links based on current page
        function updatePaginationLinks() {
            paginationContainer.empty(); // Clear previous pagination links

            let totalPages = Math.ceil(allItems.length / itemsPerPage);

            let prevPageLink = $('<span/>', {
                class: 'pagination-link',
                text: '<<Prev',
                click: function(e) {
                    e.preventDefault(); // Prevent default link behavior
                    if (currentPage > 1) {
                        currentPage--;
                        displayCheckboxes(currentPage);
                        updatePaginationLinks();
                    }
                }
            });

            if (currentPage > 1) {
                paginationContainer.append(prevPageLink);
            }

            for (let i = 1; i <= totalPages; i++) {
                let pageLink = $('<span/>', {
                    class: 'pagination-link',
                    text: i,
                    click: function(e) {
                        e.preventDefault(); // Prevent default link behavior
                        currentPage = i;
                        displayCheckboxes(currentPage);
                        updatePaginationLinks();
                    }
                });

                if (i === currentPage) {
                    pageLink.addClass('current-page'); // Highlight current page in green
                }

                paginationContainer.append(pageLink);
            }

            let nextPageLink = $('<span/>', {
                class: 'pagination-link',
                text: 'Next>>',
                click: function(e) {
                    e.preventDefault(); // Prevent default link behavior
                    if (currentPage < totalPages) {
                        currentPage++;
                        displayCheckboxes(currentPage);
                        updatePaginationLinks();
                    }
                }
            });

            if (currentPage < totalPages) {
                paginationContainer.append(nextPageLink);
            }
        }

        // Create pagination container
        let paginationContainer = $('<div class="pagination-container"></div>');

        // Append pagination container after checkbox container
        checkboxContainer.after(paginationContainer);

        // Initialize pagination links
        updatePaginationLinks();

    }).fail(function(jqxhr, textStatus, error) {
        console.error("Request Failed: " + textStatus + ", " + error);
    });
}
