from ..app import app
from flaskext.mysql import MySQL

import unittest


class AppTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        pass

    @classmethod
    def tearDownClass(cls):
        pass

    def setUp(self):
        self.app = app.test_client()
        self.app.testing = True
        # mysql db credentials and config
        app.config['MYSQL_DATABASE_USER'] = 'romanb@team14agileprojectserver'
        app.config['MYSQL_DATABASE_PASSWORD'] = 'adminpassword1!'
        app.config['MYSQL_DATABASE_DB'] = 'medicare'
        app.config['MYSQL_DATABASE_HOST'] = 'team14agileprojectserver.mysql.database.azure.com'

        mysql = MySQL()
        mysql.init_app(app)
        # connect to mysql DB
        self.connection = mysql.connect()
        self.cursor = self.connection.cursor()

    def tearDown(self):
        # disconnect from db
        self.cursor.close()
        pass

    def test_home_status_code(self):
        result = self.app.get('/')
        # test that we can connect to homepage and get http code 200 (OK)
        self.assertEqual(result.status_code, 200)

    def test_connection_to_mysql(self):
        # test that we establish conneciton with mysql db
        self.assertIsNotNone(self.connection)


if __name__ == '__main__':
    unittest.main()
