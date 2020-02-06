from flask import Flask, render_template, request, jsonify, json
from flaskext.mysql import MySQL

app = Flask(__name__)

app.config['MYSQL_DATABASE_USER'] = 'romanb@team14agileprojectserver'
app.config['MYSQL_DATABASE_PASSWORD'] = 'adminpassword1!'
app.config['MYSQL_DATABASE_DB'] = 'medicare'
app.config['MYSQL_DATABASE_HOST'] = 'team14agileprojectserver.mysql.database.azure.com'

mysql = MySQL()
mysql.init_app(app)


@app.route('/', methods=['GET', 'POST'])
def hello_world():
    data = "x"
    conn = mysql.connect()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM medicare WHERE provider_state = 'FL' LIMIT 2;")
    row = cursor.fetchone()
    data = cursor.fetchall()
    items = [dict(zip([key[0] for key in cursor.description], row)) for row in data]
    json_data = json.dumps(items)
    cursor.close()
    return render_template('index.html', data=json_data)


if __name__ == '__main__':
    app.run(debug=True)
