/* Copyright 2015 Google Inc. All Rights Reserved.

   Distributed under MIT license.
   See file LICENSE for detail or copy at https://opensource.org/licenses/MIT
*/

package com.xlotus.lib.core.algo.br;

/**
 * Transformations on dictionary words.
 */
final class Transform {

  private final byte[] prefix;
  private final int type;
  private final byte[] suffix;

  Transform(String prefix, int type, String suffix) {
    this.prefix = readUniBytes(prefix);
    this.type = type;
    this.suffix = readUniBytes(suffix);
  }

  static byte[] readUniBytes(String uniBytes) {
    byte[] result = new byte[uniBytes.length()];
    for (int i = 0; i < result.length; ++i) {
      result[i] = (byte) uniBytes.charAt(i);
    }
    return result;
  }

  static final Transform[] TRANSFORMS = {
      new Transform("", WordTransformType.IDENTITY, ""),
      new Transform("", WordTransformType.IDENTITY, " "),
      new Transform(" ", WordTransformType.IDENTITY, " "),
      new Transform("", WordTransformType.OMIT_FIRST_1, ""),
      new Transform("", WordTransformType.UPPERCASE_FIRST, " "),
      new Transform("", WordTransformType.IDENTITY, " the "),
      new Transform(" ", WordTransformType.IDENTITY, ""),
      new Transform("s ", WordTransformType.IDENTITY, " "),
      new Transform("", WordTransformType.IDENTITY, " of "),
      new Transform("", WordTransformType.UPPERCASE_FIRST, ""),
      new Transform("", WordTransformType.IDENTITY, " and "),
      new Transform("", WordTransformType.OMIT_FIRST_2, ""),
      new Transform("", WordTransformType.OMIT_LAST_1, ""),
      new Transform(", ", WordTransformType.IDENTITY, " "),
      new Transform("", WordTransformType.IDENTITY, ", "),
      new Transform(" ", WordTransformType.UPPERCASE_FIRST, " "),
      new Transform("", WordTransformType.IDENTITY, " in "),
      new Transform("", WordTransformType.IDENTITY, " to "),
      new Transform("e ", WordTransformType.IDENTITY, " "),
      new Transform("", WordTransformType.IDENTITY, "\""),
      new Transform("", WordTransformType.IDENTITY, "."),
      new Transform("", WordTransformType.IDENTITY, "\">"),
      new Transform("", WordTransformType.IDENTITY, "\n"),
      new Transform("", WordTransformType.OMIT_LAST_3, ""),
      new Transform("", WordTransformType.IDENTITY, "]"),
      new Transform("", WordTransformType.IDENTITY, " for "),
      new Transform("", WordTransformType.OMIT_FIRST_3, ""),
      new Transform("", WordTransformType.OMIT_LAST_2, ""),
      new Transform("", WordTransformType.IDENTITY, " a "),
      new Transform("", WordTransformType.IDENTITY, " that "),
      new Transform(" ", WordTransformType.UPPERCASE_FIRST, ""),
      new Transform("", WordTransformType.IDENTITY, ". "),
      new Transform(".", WordTransformType.IDENTITY, ""),
      new Transform(" ", WordTransformType.IDENTITY, ", "),
      new Transform("", WordTransformType.OMIT_FIRST_4, ""),
      new Transform("", WordTransformType.IDENTITY, " with "),
      new Transform("", WordTransformType.IDENTITY, "'"),
      new Transform("", WordTransformType.IDENTITY, " from "),
      new Transform("", WordTransformType.IDENTITY, " by "),
      new Transform("", WordTransformType.OMIT_FIRST_5, ""),
      new Transform("", WordTransformType.OMIT_FIRST_6, ""),
      new Transform(" the ", WordTransformType.IDENTITY, ""),
      new Transform("", WordTransformType.OMIT_LAST_4, ""),
      new Transform("", WordTransformType.IDENTITY, ". The "),
      new Transform("", WordTransformType.UPPERCASE_ALL, ""),
      new Transform("", WordTransformType.IDENTITY, " on "),
      new Transform("", WordTransformType.IDENTITY, " as "),
      new Transform("", WordTransformType.IDENTITY, " is "),
      new Transform("", WordTransformType.OMIT_LAST_7, ""),
      new Transform("", WordTransformType.OMIT_LAST_1, "ing "),
      new Transform("", WordTransformType.IDENTITY, "\n\t"),
      new Transform("", WordTransformType.IDENTITY, ":"),
      new Transform(" ", WordTransformType.IDENTITY, ". "),
      new Transform("", WordTransformType.IDENTITY, "ed "),
      new Transform("", WordTransformType.OMIT_FIRST_9, ""),
      new Transform("", WordTransformType.OMIT_FIRST_7, ""),
      new Transform("", WordTransformType.OMIT_LAST_6, ""),
      new Transform("", WordTransformType.IDENTITY, "("),
      new Transform("", WordTransformType.UPPERCASE_FIRST, ", "),
      new Transform("", WordTransformType.OMIT_LAST_8, ""),
      new Transform("", WordTransformType.IDENTITY, " at "),
      new Transform("", WordTransformType.IDENTITY, "ly "),
      new Transform(" the ", WordTransformType.IDENTITY, " of "),
      new Transform("", WordTransformType.OMIT_LAST_5, ""),
      new Transform("", WordTransformType.OMIT_LAST_9, ""),
      new Transform(" ", WordTransformType.UPPERCASE_FIRST, ", "),
      new Transform("", WordTransformType.UPPERCASE_FIRST, "\""),
      new Transform(".", WordTransformType.IDENTITY, "("),
      new Transform("", WordTransformType.UPPERCASE_ALL, " "),
      new Transform("", WordTransformType.UPPERCASE_FIRST, "\">"),
      new Transform("", WordTransformType.IDENTITY, "=\""),
      new Transform(" ", WordTransformType.IDENTITY, "."),
      new Transform(".com/", WordTransformType.IDENTITY, ""),
      new Transform(" the ", WordTransformType.IDENTITY, " of the "),
      new Transform("", WordTransformType.UPPERCASE_FIRST, "'"),
      new Transform("", WordTransformType.IDENTITY, ". This "),
      new Transform("", WordTransformType.IDENTITY, ","),
      new Transform(".", WordTransformType.IDENTITY, " "),
      new Transform("", WordTransformType.UPPERCASE_FIRST, "("),
      new Transform("", WordTransformType.UPPERCASE_FIRST, "."),
      new Transform("", WordTransformType.IDENTITY, " not "),
      new Transform(" ", WordTransformType.IDENTITY, "=\""),
      new Transform("", WordTransformType.IDENTITY, "er "),
      new Transform(" ", WordTransformType.UPPERCASE_ALL, " "),
      new Transform("", WordTransformType.IDENTITY, "al "),
      new Transform(" ", WordTransformType.UPPERCASE_ALL, ""),
      new Transform("", WordTransformType.IDENTITY, "='"),
      new Transform("", WordTransformType.UPPERCASE_ALL, "\""),
      new Transform("", WordTransformType.UPPERCASE_FIRST, ". "),
      new Transform(" ", WordTransformType.IDENTITY, "("),
      new Transform("", WordTransformType.IDENTITY, "ful "),
      new Transform(" ", WordTransformType.UPPERCASE_FIRST, ". "),
      new Transform("", WordTransformType.IDENTITY, "ive "),
      new Transform("", WordTransformType.IDENTITY, "less "),
      new Transform("", WordTransformType.UPPERCASE_ALL, "'"),
      new Transform("", WordTransformType.IDENTITY, "est "),
      new Transform(" ", WordTransformType.UPPERCASE_FIRST, "."),
      new Transform("", WordTransformType.UPPERCASE_ALL, "\">"),
      new Transform(" ", WordTransformType.IDENTITY, "='"),
      new Transform("", WordTransformType.UPPERCASE_FIRST, ","),
      new Transform("", WordTransformType.IDENTITY, "ize "),
      new Transform("", WordTransformType.UPPERCASE_ALL, "."),
      new Transform("\u00c2\u00a0", WordTransformType.IDENTITY, ""),
      new Transform(" ", WordTransformType.IDENTITY, ","),
      new Transform("", WordTransformType.UPPERCASE_FIRST, "=\""),
      new Transform("", WordTransformType.UPPERCASE_ALL, "=\""),
      new Transform("", WordTransformType.IDENTITY, "ous "),
      new Transform("", WordTransformType.UPPERCASE_ALL, ", "),
      new Transform("", WordTransformType.UPPERCASE_FIRST, "='"),
      new Transform(" ", WordTransformType.UPPERCASE_FIRST, ","),
      new Transform(" ", WordTransformType.UPPERCASE_ALL, "=\""),
      new Transform(" ", WordTransformType.UPPERCASE_ALL, ", "),
      new Transform("", WordTransformType.UPPERCASE_ALL, ","),
      new Transform("", WordTransformType.UPPERCASE_ALL, "("),
      new Transform("", WordTransformType.UPPERCASE_ALL, ". "),
      new Transform(" ", WordTransformType.UPPERCASE_ALL, "."),
      new Transform("", WordTransformType.UPPERCASE_ALL, "='"),
      new Transform(" ", WordTransformType.UPPERCASE_ALL, ". "),
      new Transform(" ", WordTransformType.UPPERCASE_FIRST, "=\""),
      new Transform(" ", WordTransformType.UPPERCASE_ALL, "='"),
      new Transform(" ", WordTransformType.UPPERCASE_FIRST, "='")
  };

  static int transformDictionaryWord(byte[] dst, int dstOffset, byte[] word, int wordOffset,
      int len, Transform transform) {
    int offset = dstOffset;

    // Copy prefix.
    byte[] string = transform.prefix;
    int tmp = string.length;
    int i = 0;
    // In most cases tmp < 10 -> no benefits from System.arrayCopy
    while (i < tmp) {
      dst[offset++] = string[i++];
    }

    // Copy trimmed word.
    int op = transform.type;
    tmp = WordTransformType.getOmitFirst(op);
    if (tmp > len) {
      tmp = len;
    }
    wordOffset += tmp;
    len -= tmp;
    len -= WordTransformType.getOmitLast(op);
    i = len;
    while (i > 0) {
      dst[offset++] = word[wordOffset++];
      i--;
    }

    if (op == WordTransformType.UPPERCASE_ALL || op == WordTransformType.UPPERCASE_FIRST) {
      int uppercaseOffset = offset - len;
      if (op == WordTransformType.UPPERCASE_FIRST) {
        len = 1;
      }
      while (len > 0) {
        tmp = dst[uppercaseOffset] & 0xFF;
        if (tmp < 0xc0) {
          if (tmp >= 'a' && tmp <= 'z') {
            dst[uppercaseOffset] ^= (byte) 32;
          }
          uppercaseOffset += 1;
          len -= 1;
        } else if (tmp < 0xe0) {
          dst[uppercaseOffset + 1] ^= (byte) 32;
          uppercaseOffset += 2;
          len -= 2;
        } else {
          dst[uppercaseOffset + 2] ^= (byte) 5;
          uppercaseOffset += 3;
          len -= 3;
        }
      }
    }

    // Copy suffix.
    string = transform.suffix;
    tmp = string.length;
    i = 0;
    while (i < tmp) {
      dst[offset++] = string[i++];
    }

    return offset - dstOffset;
  }
}
