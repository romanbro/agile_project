from flask import Flask, render_template, request
from flaskext.mysql import MySQL
# from flask_mysqldb import MySQL

app = Flask(__name__)

app.config['MYSQL_DATABASE_USER'] = 'romanb@team14agileprojectserver'
app.config['MYSQL_DATABASE_PASSWORD'] = 'adminpassword1!'
app.config['MYSQL_DATABASE_DB'] = 'medicare'
app.config['MYSQL_DATABASE_HOST'] = 'team14agileprojectserver.mysql.database.azure.com'

mysql = MySQL()
mysql.init_app(app)

@app.route('/data', methods=['GET', 'POST'])
def hello_world():
    data = "x"
    # if request.method == "GET":
        # details = request.form
        # location = details['location']
        # procCode = details['procCode']
    # cur = mysql.connection.cursor()
    # cursor = mysql.get_db().cursor()
    conn = mysql.connect()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM medicare WHERE provider_state = 'FL';")
    row = cursor.fetchone()
    data = cursor.fetchall()
    # mysql.connection.commit()
    cursor.close()
    return render_template('index.html', data=data, content_type='application/json')


if __name__ == '__main__':
    app.run(debug=True)
