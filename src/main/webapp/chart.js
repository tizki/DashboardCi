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


    var getAvgDuration = function (repoName) {
        var jsonData = $.ajax({
            url: "/" + repoName +"/avgDuration",
            dataType: "json",
            async: false
        }).responseJSON;
        return jsonData.avgDuration
    }

    $(document).ready(function () {
            $("#averageDuration").text(getAvgDuration("Platform"))
        }
    )
    $(document).ready(function () {
            $("#averageDurationUI").text(getAvgDuration("UI"))
        }
    )
    $(document).ready(function () {
            $("#averageDurationSaw").text(getAvgDuration("Saw"))
        }
    )
    var getTimeToFix = function (repoName) {
        var jsonData = $.ajax({
            url: "/" + repoName +"/timeToFix",
            dataType: "json",
            async: false
        }).responseJSON;
        return jsonData.timeToFix
    }

    $(document).ready(function () {
            $("#timeToFix").text(getTimeToFix("Platform"))
        }
    )
    $(document).ready(function () {
            $("#timeToFixUI").text(getTimeToFix("UI"))
        }
    )
    $(document).ready(function () {
            $("#timeToFixSaw").text(getTimeToFix("Saw"))
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
//        colors: ['#B0DF00', '#D52D2C', '#A6A6A6', '#FDE06A']
        colors: ['#29A329', '#D52D2C', '#747474', '#E6E600'],
        pieSliceTextStyle: { color: 'black' }
    };

    return [data, options]
 }

