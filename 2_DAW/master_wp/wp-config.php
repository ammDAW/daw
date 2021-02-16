<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://wordpress.org/support/article/editing-wp-config-php/
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'master_wp' );

/** MySQL database username */
define( 'DB_USER', 'root' );

/** MySQL database password */
define( 'DB_PASSWORD', '' );

/** MySQL hostname */
define( 'DB_HOST', 'localhost' );

/** Database Charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8mb4' );

/** The Database Collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         ' u^oEI#L|S`a[`2$H8&vnvBNDsfQ, }A,#@!3kG1w~_j>@uiRj5ojO>6&D{$9eUs' );
define( 'SECURE_AUTH_KEY',  ':G=palJT^Cftb5dR$u@dM:0q@iQJ9Fs5R:Z4x$y`6u-]H7zFMg(YFOz5G<JS7mxL' );
define( 'LOGGED_IN_KEY',    'h7Qh3z:`K.g{T,LC-wI7g=yv_)i8-jDh9]s#d)cr$L?%(Qy*!Py?vFL-_7Q509Q,' );
define( 'NONCE_KEY',        'r1]g.E)X]!1o)4s4lJ6R5(Ml_8Zwx!&Uy5)YzruSE0E-|r`k1<EiN35;_iW[9-?b' );
define( 'AUTH_SALT',        'k?Yu0O.lc8vJ6#`|a&X{ow5y;PAnRYjx.r/Fm.vuaRKq&-?i.]DbA(!# a8 [)c ' );
define( 'SECURE_AUTH_SALT', 'g>nd0RG6CjxZ.Zrf*U]10*p_UJ6(#EKY02Ne4DePCwc:VkN`sff8V%w(~-Jb#_p5' );
define( 'LOGGED_IN_SALT',   'mH<45#7Sk9&>&%(CG7`Z7ZafOY{`C0./|pq|-neY[!$&?{@nrFatuhB#h:u[C31E' );
define( 'NONCE_SALT',       'OB+w(ozd-AQRg85;%3,HSpg%YwnM_A_e]53Z)fgu@{Ubs6?*kK G4(4,[A@,xB3s' );

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://wordpress.org/support/article/debugging-in-wordpress/
 */
define( 'WP_DEBUG', false );

/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';
