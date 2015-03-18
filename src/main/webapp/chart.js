// Load the Visualization API and the piechart package.
google.load('visualization', '1', {'packages': ['corechart']});

// Set a callback to run when the Google Visualization API is loaded.
google.setOnLoadCallback(createChart);

function createChart(){

    var chartName = ["piechartPlatform","piechartUI","piechartSaw"]
    var repoNames = ["Platform","UI","Saw"]

    // Instantiate and draw our chart, passing in some options.

    for(i=0; i<chartName.length; i++)
    {
        var chartDetails = drawChart(repoNames[i])
        var chart = new google.visualization.PieChart(document.getElementById(chartName[i]));
        chart.draw(chartDetails[0], chartDetails[1]);
    }


    var getAvgDuration = function () {
        var jsonData = $.ajax({
            url: "/avgDuration",
            dataType: "json",
            async: false
        }).responseJSON;
        return jsonData.avgDuration
    }

    $(document).ready(function () {
            $("#averageDuration").text(getAvgDuration())
        }
    )
    var getTimeToFix = function () {
        var jsonData = $.ajax({
            url: "/timeToFix",
            dataType: "json",
            async: false
        }).responseJSON;
        return jsonData.timeToFix
    }

    $(document).ready(function () {
            $("#timeToFix").text(getTimeToFix())
        }
    )
}
function drawChart(chartName) {
    var jsonData = $.ajax({
        url: "/" + chartName +"/distribution",
        dataType: "json",
        async: false
    }).responseText;

    var data = new google.visualization.DataTable();

// Declare columns
    data.addColumn('string', 'Build Result');
    data.addColumn('number', 'Percentage');

    var result = JSON.parse(jsonData);
    for (var p in result) {
        var ar = [];
        ar.push(p)
        ar.push(result[p]);
        data.addRow(ar);
    }

    // Create our data table out of JSON data loaded from server.
    // var data = new google.visualization.DataTable(jsonData);
    var options = {
        title: 'Builds Result Distribution ',
        colors: ['#B0DF00', '#D52D2C', '#A6A6A6', '#FDE06A']
    };

    return [data, options]
 }

